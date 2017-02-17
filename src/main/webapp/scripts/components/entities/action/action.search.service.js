'use strict';

angular.module('creamApp')
    .factory('ActionSearch', function ($resource) {
        return $resource('api/_search/actions/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
