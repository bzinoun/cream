'use strict';

angular.module('creamApp')
	.controller('RefSituationFamilialeDeleteController', function($scope, $uibModalInstance, entity, RefSituationFamiliale) {

        $scope.refSituationFamiliale = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            RefSituationFamiliale.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
