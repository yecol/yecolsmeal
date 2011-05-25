
            var init = function(){
            
                var map = new QQMap.QMap(document.getElementById("container"), {
                    center: new QQMap.QLatLng(39.920, 116.405),
                    zoomLevel: 13
                });
                
                var center = new QQMap.QLatLng(39.920, 116.405);
                
                var drawCircle = false;
                var drawPolygon = false;
                
                var location;
                var hasLocation = false;
                
                var dashPolylinePath = new Array(2);
                var dashPolyline = new QQMap.QPolyline({
                    strokeColor: '#0000FF',
                    strokeDashStyle: 'dash',
                    strokeOpacity: 0.5,
                    strokeWeight: 5
                });
                
                var solidPolylinePath = new Array();
                var solidPolyline = new QQMap.QPolyline({
                    strokeColor: '#0000FF',
                    strokeWeight: 5,
                    strokeOpacity: 0.5,
                    strokeDashStyle: 'solid'
                });
                
                var polygonPath = new Array();
                var polygon = new QQMap.QPolygon({
                    strokeColor: '#0000FF',
                    strokeOpacity: 0.5,
                    strokeWeight: 5
                });
                
                // add a circle
                var circle = new QQMap.QCircle({});
                
                // add a marker
                var marker = new QQMap.QMarker({});
                
                // marker's click event
                var markerInfo = new QQMap.QInfoWindow({
                });
                
                QQMap.QEvent.addListener(marker, 'click', function(){
                    if (drawPolygon == true) {
                        drawPolygon = false;
                        hasLocation = false;
                        
                        polygon.setPath(solidPolylinePath);
                        polygon.setMap(map);
                        
                        solidPolygonPath = [];
                        solidPolyline.setPath(solidPolygonPath);
                        
                        // dashPolygonPath = [];
                        dashPolyline.setPath([]);
                        
                    }
                    else {
                        document.getElementById('info').innerHTML = 'Start a a polygon!';
						markerInfo.setMap(map);
                        markerInfo.open('<div style="text-align:center;white-space:nowrap;margin:10px;">The shop\'s location</div>', marker);
                    }
                });
                
                
                // Mouse-move event
                QQMap.QEvent.addListener(map, 'mousemove', function(event){
                
                    var latLng = event.qLatLng;// lat =
												// latLng.getLat().toFixed(5);
                    if (drawCircle == true && hasLocation == true) {
                    
                        dashPolylinePath[1] = latLng;
                        dashPolyline.setPath(dashPolylinePath);
                        
                        circle.setRadius(map.getDistance(location, latLng));
                    }
                    
                    if (drawPolygon == true && hasLocation == true) {
                    
                        dashPolylinePath[1] = latLng;
                        dashPolyline.setPath(dashPolylinePath);
                    }
                    
                });
                
                // The event of click the map
                QQMap.QEvent.addListener(map, 'click', function(event){
                
                    var latLng = event.qLatLng;
                    
                    if (drawCircle == true) {
                    
                        if (hasLocation == false) {
                            hasLocation = true;
                            location = latLng;
                            
                            marker.setPosition(latLng);
                            marker.setMap(map);
                            
                            circle.setCenter(latLng);
                            circle.setRadius(0);
                            circle.setMap(map);
                            
                            dashPolylinePath[0] = latLng;
                            dashPolylinePath[1] = latLng;
                            dashPolyline.setPath(dashPolylinePath);
                            dashPolyline.setMap(map);
                            
                        }
                        else {
                            drawCircle = false;
                            
                            hasLocation = false;
                            
                            circle.setRadius(map.getDistance(location, latLng));
                            
                            dashPolyline.setPath([]);
                        }
                        
                    }
                    
                    if (drawPolygon == true) {
                    
                        dashPolylinePath[0] = latLng;
                        dashPolylinePath[1] = latLng;
                        dashPolyline.setPath(dashPolylinePath);
                        dashPolyline.setMap(map);
                        
                        if (hasLocation == false) {
                        
                            hasLocation = true;
                            location = latLng;
                            
                            marker.setPosition(latLng);
                            marker.setMap(map);
                            solidPolylinePath = []; 
                             
                        }
                        
                        solidPolylinePath.push(latLng);
                        solidPolyline.setPath(solidPolylinePath);
                        solidPolyline.setMap(map);
                    }
                    
                });
                
                
                // ÓÒ¼ü²Ëµ¥
                var contextMenu = new QQMap.QContextMenuControl();
                contextMenu.setMap(map);
                contextMenu.addItem('Draw a circle!', drawCircleFunc);
                contextMenu.addSeparator();
                contextMenu.addItem('Draw a polygon!', drawPolygonFunc);
                contextMenu.addTarget(map);
                
                function drawCircleFunc(){
                
                    circle.setMap(null);
                    marker.setMap(null);
                    polygon.setMap(null);
                    dashPolyline.setMap(null);
                    solidPolyline.setMap(null);
					markerInfo.setMap(null);
                    
                    drawCircle = true;
                    document.getElementById('info').innerHTML = 'Start drawing a circle!';
                }
                
                function drawPolygonFunc(){
                    circle.setMap(null);
                    marker.setMap(null);
                    polygon.setMap(null);
                    dashPolyline.setMap(null);
                    solidPolyline.setMap(null);
					markerInfo.setMap(null);
                    
                    drawPolygon = true;
                    document.getElementById('info').innerHTML = 'Start drawing a polygon!';
                }
               
                
}
