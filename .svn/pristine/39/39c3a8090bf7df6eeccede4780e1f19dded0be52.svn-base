'use strict';

angular.module('creamApp')
    .controller('ActionDetailController', function ($scope, $rootScope, $stateParams, entity, Action, Tache) {
        $scope.action = entity;
        $scope.load = function (id) {
            Action.get({id: id}, function(result) {
                $scope.action = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:actionUpdate', function(event, result) {
            $scope.action = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
