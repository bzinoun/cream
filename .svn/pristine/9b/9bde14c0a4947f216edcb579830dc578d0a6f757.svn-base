'use strict';

angular.module('creamApp')
	.controller('CompagneDeleteController', function($scope, $uibModalInstance, entity, Compagne) {

        $scope.compagne = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Compagne.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
