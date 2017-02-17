'use strict';

angular.module('creamApp')
    .controller('TacheDetailController', function ($scope, $rootScope, $stateParams, DataUtils, entity, Tache, Prospection, Action, RefStatutTache) {
        $scope.tache = entity;
        $scope.load = function (id) {
            Tache.get({id: id}, function(result) {
                $scope.tache = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:tacheUpdate', function(event, result) {
            $scope.tache = result;
        });
        $scope.$on('$destroy', unsubscribe);

        $scope.byteSize = DataUtils.byteSize;
    });
