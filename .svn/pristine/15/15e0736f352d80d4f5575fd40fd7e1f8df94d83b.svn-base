'use strict';

angular.module('creamApp')
	.controller('PersonneDeleteController', function($scope, $uibModalInstance, entity, Personne) {

        $scope.personne = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Personne.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
