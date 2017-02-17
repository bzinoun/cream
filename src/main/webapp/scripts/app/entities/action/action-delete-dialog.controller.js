'use strict';

angular.module('creamApp')
	.controller('ActionDeleteController', function($scope, $uibModalInstance, entity, Action) {

        $scope.action = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Action.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
