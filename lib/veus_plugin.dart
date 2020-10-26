
import 'dart:async';

import 'package:flutter/services.dart';

class VeusPlugin {
  static const MethodChannel _channel =
      const MethodChannel('veus_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
