//
//  CustomCameraCaptureView.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import AVFoundation
import UIKit

struct CustomCameraCaptureView: UIViewControllerRepresentable {
    typealias UIViewControllerType = UIViewController
        
    let cameraService: CameraService
    let didFinishProcessingPhoto: ((Result<AVCapturePhoto, Error>) -> Void)
    
    func makeUIViewController(context: Context) -> UIViewController {
        cameraService.start(delegate: context.coordinator) { error in
            if let error = error {
                didFinishProcessingPhoto(.failure(error))
                return
            }
        }
        
        let viewController = UIViewController()
        viewController.view.backgroundColor = .black
        viewController.view.layer.addSublayer(cameraService.previewLayer)
        cameraService.previewLayer.frame = viewController.view.bounds
        
        return viewController
    }
    
    func makeCoordinator() -> Coordinator {
        Coordinator(self, didFinishProcessingPhoto: didFinishProcessingPhoto)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
    
    class Coordinator: NSObject, AVCapturePhotoCaptureDelegate {
        let parent: CustomCameraCaptureView
        private var didFinishProcessingPhoto: ((Result<AVCapturePhoto, Error>) -> Void)
        
        init(_ parent: CustomCameraCaptureView, didFinishProcessingPhoto: @escaping ((Result<AVCapturePhoto, Error>) -> Void)) {
            self.parent = parent
            self.didFinishProcessingPhoto = didFinishProcessingPhoto
        }
        
        func photoOutput(_ output: AVCapturePhotoOutput, didFinishProcessingPhoto photo: AVCapturePhoto, error: Error?) {
            if let error = error {
                didFinishProcessingPhoto(.failure(error))
                return
            }
            
            didFinishProcessingPhoto(.success(photo))
        }
    }
}

