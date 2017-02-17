'use strict';

angular.module('creamApp').controller('ActionDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Action', 'Tache',
        function($scope, $stateParams, $uibModalInstance, entity, Action, Tache) {
        $scope.action = entity;
        $scope.taches = Tache.query();
        $scope.load = function(id) {
            Action.get({id : id}, function(result) {
                $scope.action = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:actionUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
        	debugger ;
            $scope.isSaving = true;
            if ($scope.action.id != null) {
                Action.update($scope.action, onSaveSuccess, onSaveError);
            } else {
                Action.save($scope.action, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.datePickerForDateDebut = {};

        $scope.datePickerForDateDebut.status = {
            opened: false
        };

        $scope.datePickerForDateDebutOpen = function($event) {
            $scope.datePickerForDateDebut.status.opened = true;
        };
        $scope.datePickerForDateFin = {};

        $scope.datePickerForDateFin.status = {
            opened: false
        };

        $scope.datePickerForDateFinOpen = function($event) {
            $scope.datePickerForDateFin.status.opened = true;
        };
        
        $scope.initDecision=function (decision){
        	debugger ;
        	$scope.action.decision = decision ; 
        	
        }        
        
        
        $scope.getIconeAction= function (type){
        	if("APPEL" == type){
        		return "fa fa-phone"
        		
        	}
        	return " fa fa-tag"
        }
        
        
}]);
