'use strict';

angular.module('creamApp').controller('RefSituationFamilialeDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'RefSituationFamiliale', 'Personne',
        function($scope, $stateParams, $uibModalInstance, entity, RefSituationFamiliale, Personne) {

        $scope.refSituationFamiliale = entity;
        $scope.personnes = Personne.query();
        $scope.load = function(id) {
            RefSituationFamiliale.get({id : id}, function(result) {
                $scope.refSituationFamiliale = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:refSituationFamilialeUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.refSituationFamiliale.id != null) {
                RefSituationFamiliale.update($scope.refSituationFamiliale, onSaveSuccess, onSaveError);
            } else {
                RefSituationFamiliale.save($scope.refSituationFamiliale, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
