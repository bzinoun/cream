'use strict';

angular.module('creamApp')
    .controller('PerferenceDetailController', function ($scope, $rootScope, $stateParams, DataUtils, entity, Perference) {
        $scope.perference = entity;
        $scope.load = function (id) {
            Perference.get({id: id}, function(result) {
                $scope.perference = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:perferenceUpdate', function(event, result) {
            $scope.perference = result;
        });
        $scope.$on('$destroy', unsubscribe);

        $scope.byteSize = DataUtils.byteSize;
    });
