'use strict';

angular.module('creamApp')
    .factory('RefStatutTache', function ($resource, DateUtils) {
        return $resource('api/refStatutTaches/:id', {}, {
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
