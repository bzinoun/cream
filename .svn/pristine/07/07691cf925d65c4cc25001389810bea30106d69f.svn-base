'use strict';

angular.module('creamApp')
    .factory('MonitoringService', function ($rootScope, $http) {
        return {
            getMetrics: function () {
                return $http.get('metrics/metrics').then(function (response) {
                    return response.data;
                });
            },

            checkHealth: function () {
                return $http.get('health').then(function (response) {
                    return response.data;
                });
            },

            threadDump: function () {
                return $http.get('dump').then(function (response) {
                    return response.data;
                });
            }
        };
    });
    
angular.module('creamApp')
            .factory('ElasticIndexService', function ($resource) {
                return $resource('api/elasticsearch/index', {}, {
                    'indexAll': { method: 'POST'}
                });
            });
    
