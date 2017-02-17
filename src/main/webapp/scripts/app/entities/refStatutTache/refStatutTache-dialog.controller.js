'use strict';

angular.module('creamApp').controller('RefStatutTacheDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'RefStatutTache', 'Tache',
        function($scope, $stateParams, $uibModalInstance, entity, RefStatutTache, Tache) {

        $scope.refStatutTache = entity;
        $scope.taches = Tache.query();
        $scope.load = function(id) {
            RefStatutTache.get({id : id}, function(result) {
                $scope.refStatutTache = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:refStatutTacheUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.refStatutTache.id != null) {
                RefStatutTache.update($scope.refStatutTache, onSaveSuccess, onSaveError);
            } else {
                RefStatutTache.save($scope.refStatutTache, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
