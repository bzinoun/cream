'use strict';

angular.module('creamApp')
	.controller('RefStatutProspectionDeleteController', function($scope, $uibModalInstance, entity, RefStatutProspection) {

        $scope.refStatutProspection = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            RefStatutProspection.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
