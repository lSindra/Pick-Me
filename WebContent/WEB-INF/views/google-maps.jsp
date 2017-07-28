<!DOCTYPE html>
<html>
<head>
    <title>Save a Place</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">

    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 50%;
            width: 50%;
        }
        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
    <script>
        // When you add a marker using a Place instead of a location, the Maps
        // API will automatically add a 'Save to Google Maps' link to any info
        // window associated with that marker.
        function initMap() {
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 17,
                center: {lat: -33.8666, lng: 151.1958}
            });

            var marker = new google.maps.Marker({
                map: map,
                // Define the place with a location, and a query string.
                place: {
                    location: {lat: -33.8666, lng: 151.1958},
                    query: 'Google, Sydney, Australia'

                },
                // Attributions help users find your site again.
                attribution: {
                    source: 'Google Maps JavaScript API',
                    webUrl: 'https://developers.google.com/maps/'
                }
            });

            // Construct a new InfoWindow.
            var infoWindow = new google.maps.InfoWindow({
                content: 'Google Sydney'
            });

            // Opens the InfoWindow when marker is clicked.
            marker.addListener('click', function() {
                infoWindow.open(map, marker);
            });
        }
    </script>
</head>
<body>
<div id="map"></div>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?v=3.27&key=AIzaSyADu4oWt3k-UNOpVfdFYo4ir0NB4zxKiIs&signed_in=true&callback=initMap">
</script>
</body>
</html>