'use strict';

angular.module('creamApp')
    .controller('RefStatutCompagneDetailController', function ($scope, $rootScope, $stateParams, entity, RefStatutCompagne, Compagne) {
        $scope.refStatutCompagne = entity;
        $scope.load = function (id) {
            RefStatutCompagne.get({id: id}, function(result) {
                $scope.refStatutCompagne = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:refStatutCompagneUpdate', function(event, result) {
            $scope.refStatutCompagne = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
