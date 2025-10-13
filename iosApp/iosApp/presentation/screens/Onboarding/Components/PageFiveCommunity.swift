//
//  PageFiveCommunity.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PageFiveCommunity: View {
    var eventClick: () -> Void
    
    var body: some View {
        ZStack {
            Color.background
                .ignoresSafeArea()
                
            VStack(alignment: .center){
                if UITraitCollection.current.userInterfaceStyle == .dark {
                    Image(resource: \.communitylight)
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 250, height: 250)
                } else {
                    Image(resource: \.communitydark)
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 250, height: 250)
                }
                Text(IosStringResources(id: SharedRes.strings().page_five_title, args: []))
                    .font(.custom(.h1Medium))
                    .fontWeight(.bold)
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                Text(IosStringResources(id: SharedRes.strings().page_five_topic, args: []))
                    .font(.custom(.pBody))
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                ButtonExplore(condition: eventClick)
            }.padding()
        }
    }
}

#Preview {
    PageFiveCommunity(eventClick: {})
}
