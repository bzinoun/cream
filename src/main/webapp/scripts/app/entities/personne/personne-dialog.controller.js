'use strict';

angular.module('creamApp').controller('PersonneDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Personne', 'Prospection', 'RefSituationFamiliale', 'RefSecteurActivite',
        function($scope, $stateParams, $uibModalInstance, entity, Personne, Prospection, RefSituationFamiliale, RefSecteurActivite) {

        $scope.personne = entity;
        $scope.prospections = Prospection.query();
        $scope.refsituationfamiliales = RefSituationFamiliale.query();
        $scope.refsecteuractivites = RefSecteurActivite.query();
        $scope.load = function(id) {
            Personne.get({id : id}, function(result) {
                $scope.personne = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:personneUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.personne.id != null) {
                Personne.update($scope.personne, onSaveSuccess, onSaveError);
            } else {
                Personne.save($scope.personne, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.datePickerForDateNaissance = {};

        $scope.datePickerForDateNaissance.status = {
            opened: false
        };

        $scope.datePickerForDateNaissanceOpen = function($event) {
            $scope.datePickerForDateNaissance.status.opened = true;
        };
        $scope.datePickerForDateObtentionPermis = {};

        $scope.datePickerForDateObtentionPermis.status = {
            opened: false
        };

        $scope.datePickerForDateObtentionPermisOpen = function($event) {
            $scope.datePickerForDateObtentionPermis.status.opened = true;
        };
}]);
