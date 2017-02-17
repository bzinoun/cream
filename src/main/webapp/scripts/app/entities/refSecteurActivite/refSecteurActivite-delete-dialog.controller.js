'use strict';

angular.module('creamApp')
	.controller('RefSecteurActiviteDeleteController', function($scope, $uibModalInstance, entity, RefSecteurActivite) {

        $scope.refSecteurActivite = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            RefSecteurActivite.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
