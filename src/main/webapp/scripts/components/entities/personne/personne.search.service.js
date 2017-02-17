'use strict';

angular.module('creamApp')
    .factory('PersonneSearch', function ($resource) {
        return $resource('api/_search/personnes/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
