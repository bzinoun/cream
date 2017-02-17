'use strict';

angular.module('creamApp')
    .controller('RefSituationFamilialeDetailController', function ($scope, $rootScope, $stateParams, entity, RefSituationFamiliale, Personne) {
        $scope.refSituationFamiliale = entity;
        $scope.load = function (id) {
            RefSituationFamiliale.get({id: id}, function(result) {
                $scope.refSituationFamiliale = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:refSituationFamilialeUpdate', function(event, result) {
            $scope.refSituationFamiliale = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
