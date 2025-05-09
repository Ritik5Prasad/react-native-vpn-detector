require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "VpnDetector"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["homepage"]
  s.license      = package["license"]
  s.authors      = package["author"]

  s.platforms    = { :ios => "12.0" } 

  s.source       = {
    :git => "https://github.com/Ritik5Prasad/react-native-vpn-detector.git",
    :tag => "#{s.version}"
  }

  s.source_files = "ios/**/*.{h,m,mm,cpp,swift}"  
  s.private_header_files = "ios/**/*.h"

  s.requires_arc = true

  if respond_to?(:install_modules_dependencies, true)
    install_modules_dependencies(s)
  else
    s.dependency "React-Core"
  end
end
