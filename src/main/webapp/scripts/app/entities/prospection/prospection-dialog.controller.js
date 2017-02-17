'use strict';

angular.module('creamApp').controller('ProspectionDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Prospection', 'Personne', 'Compagne', 'Tache', 'RefStatutProspection',
        function($scope, $stateParams, $uibModalInstance, entity, Prospection, Personne, Compagne, Tache, RefStatutProspection) {

        $scope.prospection = entity;
        $scope.personnes = Personne.query();
        $scope.compagnes = Compagne.query();
        $scope.taches = Tache.query();
        $scope.refstatutprospections = RefStatutProspection.query();
        
        
        if($stateParams.state != null && $stateParams.state =="5")
        { // Etat en attent lors de la Qualif 
        	$scope.qualification = true ; 
        }
        
        $scope.load = function(id) {
            Prospection.get({id : id}, function(result) {
                $scope.prospection = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:prospectionUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.prospection.id != null) {
                Prospection.update($scope.prospection, onSaveSuccess, onSaveError);
            } else {
                Prospection.save($scope.prospection, onSaveSuccess, onSaveError);
            }
        };
        
        $scope.qualifier = function () {
            $scope.isSaving = true;
            if($stateParams.state != null && $stateParams.state =="5")
            { // Etat en attent lors de la Qualif 
            	$scope.prospection.statutProspectionId =  $stateParams.state;
            }
            
            if ($scope.prospection.id != null) {
                Prospection.update($scope.prospection, onSaveSuccess, onSaveError);
            } else {
                Prospection.save($scope.prospection, onSaveSuccess, onSaveError);
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
        
        $scope.datePickerForDateEcheance = {};

        $scope.datePickerForDateEcheance.status = {
            opened: false
        };

        $scope.datePickerForDateEcheanceOpen = function($event) {
            $scope.datePickerForDateEcheance.status.opened = true;
        };
        $scope.datePickerForDateCirculation = {};
        
        $scope.datePickerForDateCirculation.status = {
        		opened: false
        };
        
        $scope.datePickerForDateCirculationOpen = function($event) {
        	$scope.datePickerForDateCirculation.status.opened = true;
        };
        
        
        
        
        
        
      $scope.compagnies=   [
     	{
     		
     		libelle: "AXA"
     	},
     	{
     		
     		libelle: "SAHAM"
     	},
     	{
     		
     		libelle: "ZURICH"
     	},
     	{
     		
     		libelle: "RMA"
     	}
        
      ] 
        
}]);
