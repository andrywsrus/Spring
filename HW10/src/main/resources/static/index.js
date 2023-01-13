angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                part_title: $scope.filter ? $scope.filter.part_title : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data.content;
            $scope.filter.min_price = null;
            $scope.filter.max_price = null;
            $scope.filter.part_title = null;
        });
    };

    $scope.deleteProduct = function (productId) {
        $http({
            url: contextPath + '/products',
            method: 'DELETE',
            params: {
                id: productId,
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.changeprice = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.addProduct = function (product) {
        $http.post(contextPath + '/products', product).then(function (response) {
            $scope.product = null;
            $scope.loadProducts();
        });
    }

    $scope.loadCart = function () {
        $http.get(contextPath + '/carts')
            .then(function (response) {
                $scope.CartList = response.data;
            });
    };

    $scope.addToCart = function (productId) {
        $http({
            url: contextPath + '/carts/add',
            method: 'GET',
            params: {
                productId: productId,
            }
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteProductFromCart = function (productId) {
        $http({
            url: contextPath + '/carts/remove/' + productId,
            method: 'GET',
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadProducts();
    $scope.loadCart();
});