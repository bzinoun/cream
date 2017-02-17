'use strict';

angular.module('creamApp').controller('CompagneDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Compagne', 'Prospection', 'RefStatutCompagne',
        function($scope, $stateParams, $uibModalInstance, entity, Compagne, Prospection, RefStatutCompagne) {

        $scope.compagne = entity;
        $scope.prospections = Prospection.query();
        $scope.refstatutcompagnes = RefStatutCompagne.query();
        $scope.load = function(id) {
            Compagne.get({id : id}, function(result) {
                $scope.compagne = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:compagneUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.compagne.id != null) {
                Compagne.update($scope.compagne, onSaveSuccess, onSaveError);
            } else {
                Compagne.save($scope.compagne, onSaveSuccess, onSaveError);
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
}]);
