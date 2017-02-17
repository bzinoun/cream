'use strict';

angular.module('creamApp')
	.controller('ProspectionDeleteController', function($scope, $uibModalInstance, entity, Prospection) {

        $scope.prospection = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Prospection.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
