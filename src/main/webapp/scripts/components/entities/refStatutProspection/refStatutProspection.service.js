'use strict';

angular.module('creamApp')
    .factory('RefStatutProspection', function ($resource, DateUtils) {
        return $resource('api/refStatutProspections/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    });
