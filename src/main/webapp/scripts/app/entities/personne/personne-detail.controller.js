'use strict';

angular.module('creamApp')
    .controller('PersonneDetailController', function ($scope, $rootScope, $stateParams, entity, Personne, Prospection, RefSituationFamiliale, RefSecteurActivite) {
        $scope.personne = entity;
        $scope.load = function (id) {
            Personne.get({id: id}, function(result) {
                $scope.personne = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:personneUpdate', function(event, result) {
            $scope.personne = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
