//
//  CameraScreen.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Photos


class CameraDataHolder: ObservableObject {
    @Published var latitudeValue: Double = 0.0
    @Published var longitudeValue: Double = 0.0
    @Published var titleValue: String = ""
    @Published var descriptionValue: String = ""
}

struct CameraScreen: View {
    @State private var selection: String? = nil
    @State private var capturedPhoto: UIImage? = nil
    @State private var show: Bool = true
    let cameraService: CameraService = CameraService()
    @ObservedObject var viewModel: CameraViewModel
    
    init(latitudeValue: Double, longitudeValue: Double, titleValue: String, descriptionValue: String) {
        viewModel = CameraViewModel(latitudeValue: latitudeValue, longitudeValue: longitudeValue, titleValue: titleValue, descriptionValue: descriptionValue)
    }
    
    var body: some View {
        ZStack {
            Color.background.ignoresSafeArea()
            NavigationLink(destination: HomeScreen(),tag: "Home", selection: $selection){
                EmptyView()
            }
            CustomCameraCaptureView(cameraService: cameraService) { result in
                switch result {
                    case .success(let photoData):
                        if let data = photoData.fileDataRepresentation(),
                        let image = UIImage(data: data) {
                            capturedPhoto = image
                            selection = "Home"
                            print("Next Page")
                            
                        } else {
                            print("Can not convert photo from data")
                        }
                    case .failure(let error):
                        print(error.localizedDescription)
                }

                show.toggle()
            }.ignoresSafeArea()
            VStack {
                Spacer()
                
                HStack(alignment: .center){
                    Spacer().frame(width: 90)
                    Button {
                        cameraService.capturePhoto()
                        
                    } label: {
                        Circle()
                            .fill(Color.white)
                            .frame(width: 60, height: 60, alignment: .center)
                    }
                    .padding(.bottom)
                    Spacer().frame(width: 40)
                    Button(action: {
                        cameraService.toggleCameraPosition()
                    }) {
                        Image(systemName: "camera.rotate.fill")
                            .resizable()
                            .frame(width: 60, height: 50)
                            .foregroundColor(Color.white)
                    }
                    .padding(.bottom)
                }
                
            }
        }.toolbar {
            ToolbarItem(placement: .navigationBarTrailing){
                Button(action: {
                    selection = "Home"
                }) {
                    ZStack{
                        Image(systemName:"xmark").resizable().frame(width: 30,height: 30).foregroundColor(Color.white)
                    }
                }
            }
        }.navigationBarBackButtonHidden(true)
    }
}
