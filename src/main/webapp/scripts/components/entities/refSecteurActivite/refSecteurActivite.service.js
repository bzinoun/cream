'use strict';

angular.module('creamApp')
    .factory('RefSecteurActivite', function ($resource, DateUtils) {
        return $resource('api/refSecteurActivites/:id', {}, {
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
