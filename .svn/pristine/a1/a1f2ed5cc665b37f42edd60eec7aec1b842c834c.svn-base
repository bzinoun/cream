'use strict';

angular.module('creamApp')
    .controller('RefStatutTacheDetailController', function ($scope, $rootScope, $stateParams, entity, RefStatutTache, Tache) {
        $scope.refStatutTache = entity;
        $scope.load = function (id) {
            RefStatutTache.get({id: id}, function(result) {
                $scope.refStatutTache = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:refStatutTacheUpdate', function(event, result) {
            $scope.refStatutTache = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
