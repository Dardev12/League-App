//
//  ProfilUserInfo.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

class UserInfoDataHolder: ObservableObject {
    @Published var imageURL = URL(string: "")
}


struct ProfilUserInfo: View {
    @Binding var isLoading: Bool
    @State private var image: UIImage = UIImage()
    @State private var isImageLoaded: Bool = false
    @ObservedObject var imageLoader: ImageLoader = ImageLoader(urlString: "")
    @ObservedObject var dataHolder = UserInfoDataHolder()
    
    init(
        imageURL: URL?
    ) {
        // Initialize the binding before using self
        self._isLoading = .constant(false)
        // Now it's safe to access other stored properties via self
        self.dataHolder.imageURL = imageURL
    }

    var body: some View {
        VStack(alignment: .center) {
            if isLoading {
                ProgressView()
                    .progressViewStyle(CircularProgressViewStyle())
                    .padding()
            } else {
                Spacer().frame(height: 5)
                Image(uiImage: image)
                    .resizable()
                    .scaledToFill()
                    .frame(width: 150, height: 150)
                    .clipShape(Circle())
                    .overlay(Circle().stroke(Color.black, lineWidth: 3))
                    .onReceive(ImageLoader(urlString: "\(self.dataHolder.imageURL?.absoluteString ?? "https://firebasestorage.googleapis.com/v0/b/map-project-land.appspot.com/o/Groupe%2071.png?alt=media&token=c53348ca-eb3a-49a1-acc6-1040e0ab05d4")").didChange) { data in
                        if !self.isImageLoaded {
                            self.image = UIImage(data: data) ?? UIImage()
                            self.isImageLoaded = true
                        }
                    }

                Spacer().frame(height: 10)
                
                HStack {
                    Text("[USER NAME]")
                        .fontWeight(.bold)
                        .padding(2)
                }
            }
        }.frame(maxWidth: .infinity)
    }
}

