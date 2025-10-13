//
//  NodleService.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

/*import SwiftUI
import UIKit
import SwiftCBOR
import SwiftProtobuf
import NodleSDK
import SQLite
import CoreLocation
import CoreBluetooth

class NodleController: NSObject, CLLocationManagerDelegate, CBCentralManagerDelegate {
    // set location manager
    private let locationManager = CLLocationManager()
    
    // set central manager
    var centralManager: CBCentralManager?
    
    // set Nodle instance
    let nodle = Nodle.sharedInstance
    
    func startServiceNodle() {
        
        // show log for starting the app
        print("starting dummy app \(Date())")
        
        // set manager for permissions
        locationManager.delegate = self
        
        // check status for location permission
        switch CLLocationManager.authorizationStatus() {
        case .authorizedWhenInUse, .authorizedAlways:
             locationManager.requestAlwaysAuthorization()
            // ask for bluetooth permissions
            centralManager = CBCentralManager(delegate: self, queue: nil)
        case .notDetermined:
            // ask for permissions/ request always if testing background
            locationManager.requestAlwaysAuthorization()
        default:
            print("Location permission denied")
            break;
        }
    }
    
  
    func stopNodle() {
        // stop Nodle
        nodle.stop()
    }
    
    func startNodle() {
        // get current nodle version
        print(nodle.getVersion())
        
        // set sdk mode to normal
        nodle.config(key: "cron.ios-bg-mode", value: 0)
        
        // start the sdk
        nodle.start(devKey: "ss58:4hRFqZv6qauyvGBPtQxJ4fSfXzWbSX5WoyK2j1NL4PFGnF3Y", tags: "","")
        
        // call get events to receive data
        nodle.getEvents { event in
            switch event.type {
                case .BlePayloadEvent:
                     let payload = event as! NodleBluetoothRecord
                     print("Bluetooth payload available \(payload.device) delivered at \(Date())")
                    break
                case .BleStartSearching:
                    print("Bluetooth started searching \(Date())")
                    break
                case .BleStopSearching:
                    print("Bluetooth stopped searching \(Date())")
                    break
                case .BeaconPayloadEvent:
                    let payload = event as! NodleBeaconRecord
                    print("Beacon payload available \(payload.minor)")
                    break
                    
                case .BeaconStartSeaching:
                    print("Beacon started searching \(Date())")
                    break
                    
                case .BeaconStopSearching:
                    print("Beacon stopped searching \(Date())")
                    break
                
            @unknown default:
                    print("Failed to get any event")
            }
        }
    }
    
    func centralManagerDidUpdateState(_ central: CBCentralManager) {
        switch central.state {
        case .poweredOn:
            // start Nodle after Bluetooth permissions have been granted
            print("THE STATE ON APP SIDE MANAGER")
            startNodle()
            break
        case .poweredOff:
            // stop Nodle after Bluetooth is off nothing to do
            stopNodle()
            break
        default:
            break
        }
    }
    
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        // handle success
        if status == .authorizedWhenInUse || status == .authorizedAlways {
            print("Location permission have been granted")
            // ask for ble permissions
            centralManager = CBCentralManager(delegate: self, queue: nil)
        }
    }
}*/
