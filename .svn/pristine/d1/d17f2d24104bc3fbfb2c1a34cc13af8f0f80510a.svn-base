'use strict';

angular.module('creamApp').controller('RefStatutProspectionDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'RefStatutProspection', 'Prospection',
        function($scope, $stateParams, $uibModalInstance, entity, RefStatutProspection, Prospection) {

        $scope.refStatutProspection = entity;
        $scope.prospections = Prospection.query();
        $scope.load = function(id) {
            RefStatutProspection.get({id : id}, function(result) {
                $scope.refStatutProspection = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:refStatutProspectionUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.refStatutProspection.id != null) {
                RefStatutProspection.update($scope.refStatutProspection, onSaveSuccess, onSaveError);
            } else {
                RefStatutProspection.save($scope.refStatutProspection, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
