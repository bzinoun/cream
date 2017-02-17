'use strict';

angular.module('creamApp')
    .controller('RefStatutProspectionDetailController', function ($scope, $rootScope, $stateParams, entity, RefStatutProspection, Prospection) {
        $scope.refStatutProspection = entity;
        $scope.load = function (id) {
            RefStatutProspection.get({id: id}, function(result) {
                $scope.refStatutProspection = result;
            });
        };
        var unsubscribe = $rootScope.$on('creamApp:refStatutProspectionUpdate', function(event, result) {
            $scope.refStatutProspection = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
