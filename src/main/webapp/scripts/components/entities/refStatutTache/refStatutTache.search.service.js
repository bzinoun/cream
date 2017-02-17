'use strict';

angular.module('creamApp')
    .factory('RefStatutTacheSearch', function ($resource) {
        return $resource('api/_search/refStatutTaches/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
