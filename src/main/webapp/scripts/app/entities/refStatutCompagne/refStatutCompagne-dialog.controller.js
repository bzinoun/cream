'use strict';

angular.module('creamApp').controller('RefStatutCompagneDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'RefStatutCompagne', 'Compagne',
        function($scope, $stateParams, $uibModalInstance, entity, RefStatutCompagne, Compagne) {

        $scope.refStatutCompagne = entity;
        $scope.compagnes = Compagne.query();
        $scope.load = function(id) {
            RefStatutCompagne.get({id : id}, function(result) {
                $scope.refStatutCompagne = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:refStatutCompagneUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.refStatutCompagne.id != null) {
                RefStatutCompagne.update($scope.refStatutCompagne, onSaveSuccess, onSaveError);
            } else {
                RefStatutCompagne.save($scope.refStatutCompagne, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
