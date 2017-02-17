'use strict';

angular.module('creamApp')
	.controller('RefStatutCompagneDeleteController', function($scope, $uibModalInstance, entity, RefStatutCompagne) {

        $scope.refStatutCompagne = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            RefStatutCompagne.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
