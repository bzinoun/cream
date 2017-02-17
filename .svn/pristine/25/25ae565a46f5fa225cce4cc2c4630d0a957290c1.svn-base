'use strict';

angular.module('creamApp')
	.controller('RefStatutTacheDeleteController', function($scope, $uibModalInstance, entity, RefStatutTache) {

        $scope.refStatutTache = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            RefStatutTache.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
