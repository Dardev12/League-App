//
//  CameraViewModel.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

extension CameraScreen{
    @MainActor class CameraViewModel: ObservableObject {
        @Published var latitudeValue: Double = 0.0
        @Published var longitudeValue: Double = 0.0
        @Published var titleValue: String = ""
        @Published var descriptionValue: String = ""
        
        init(latitudeValue: Double, longitudeValue: Double, titleValue: String, descriptionValue: String) {
            self.latitudeValue = latitudeValue
            self.longitudeValue = longitudeValue
            self.titleValue = titleValue
            self.descriptionValue = descriptionValue
        }
    }
}
