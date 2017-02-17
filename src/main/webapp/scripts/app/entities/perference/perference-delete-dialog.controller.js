'use strict';

angular.module('creamApp')
	.controller('PerferenceDeleteController', function($scope, $uibModalInstance, entity, Perference) {

        $scope.perference = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Perference.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
