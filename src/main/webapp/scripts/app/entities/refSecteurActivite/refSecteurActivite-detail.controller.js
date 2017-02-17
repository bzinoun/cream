'use strict';

angular.module('creamApp')
    .controller('RefSecteurActiviteDetailController', function ($scope, $rootScope, $stateParams, entity, RefSecteurActivite, Personne) {
        $scope.refSecteurActivite = entity;
        $scope.load = function (id) {
            RefSecteurActivite.get({id: id}, function(result) {
                $scope.refSecteurActivite = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:refSecteurActiviteUpdate', function(event, result) {
            $scope.refSecteurActivite = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
