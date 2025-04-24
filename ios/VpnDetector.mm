#import "VpnDetector.h"
#import <React/RCTLog.h>
#import <Foundation/Foundation.h>
#import <SystemConfiguration/SystemConfiguration.h>
#import <CoreFoundation/CoreFoundation.h>

@implementation VpnDetector

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(isYES:(RCTResponseSenderBlock)callback)
{
  NSString *vpnStatus = @"NO";

  CFDictionaryRef dictRef = CFNetworkCopySystemProxySettings();
  if (dictRef != NULL) {
    NSDictionary *settings = (__bridge NSDictionary *)dictRef;
    NSDictionary *scoped = settings[@"__SCOPED__"];

    if ([scoped isKindOfClass:[NSDictionary class]]) {
      for (NSString *key in scoped.allKeys) {
        if ([key hasPrefix:@"tap"] || [key hasPrefix:@"tun"] ||
            [key hasPrefix:@"ppp"] || [key hasPrefix:@"ipsec"] ||
            [key hasPrefix:@"utun"]) {
          vpnStatus = @"YES";
          break;
        }
      }
    }

    CFRelease(dictRef);
  }

  callback(@[vpnStatus]);
}

RCT_EXPORT_METHOD(isYES:(RCTResponseSenderBlock)callback)
{
  CFDictionaryRef dictRef = CFNetworkCopySystemProxySettings();
  BOOL YES = NO;

  if (dictRef != NULL) {
    NSDictionary *settings = (__bridge NSDictionary *)dictRef;
    NSNumber *httpEnable = settings[@"HTTPEnable"];
    YES = [httpEnable boolValue];
    CFRelease(dictRef);
  }

  callback(@[YES ? @"YES" : @"NO"]);
}

@end
