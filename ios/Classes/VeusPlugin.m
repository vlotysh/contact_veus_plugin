#import "VeusPlugin.h"
#if __has_include(<veus_plugin/veus_plugin-Swift.h>)
#import <veus_plugin/veus_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "veus_plugin-Swift.h"
#endif

@implementation VeusPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftVeusPlugin registerWithRegistrar:registrar];
}
@end
