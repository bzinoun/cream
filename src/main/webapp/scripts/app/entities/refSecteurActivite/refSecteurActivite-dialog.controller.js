'use strict';

angular.module('creamApp').controller('RefSecteurActiviteDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'RefSecteurActivite', 'Personne',
        function($scope, $stateParams, $uibModalInstance, entity, RefSecteurActivite, Personne) {

        $scope.refSecteurActivite = entity;
        $scope.personnes = Personne.query();
        $scope.load = function(id) {
            RefSecteurActivite.get({id : id}, function(result) {
                $scope.refSecteurActivite = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:refSecteurActiviteUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.refSecteurActivite.id != null) {
                RefSecteurActivite.update($scope.refSecteurActivite, onSaveSuccess, onSaveError);
            } else {
                RefSecteurActivite.save($scope.refSecteurActivite, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
