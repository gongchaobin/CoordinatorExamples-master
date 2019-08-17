import 'package:flutter/material.dart';
import 'dart:ui';

void main() => runApp(_widgetForRoute(window.defaultRouteName));

Widget _widgetForRoute(String route) {
  switch(route) {
    case "route1":
      return Center(
        child: Text('Unknown route: $route', textDirection: TextDirection.ltr),
      );
  }

}
