'use strict';

angular.module('creamApp')
	.controller('TacheDeleteController', function($scope, $uibModalInstance, entity, Tache) {

        $scope.tache = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Tache.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
