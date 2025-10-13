//
//  PageOneIntroduction.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PageOneIntroduction: View {
    var eventClick: () -> Void
    
    var body: some View {
        ZStack {
            Color.background
                .ignoresSafeArea()
            VStack(alignment: .center){
                if UITraitCollection.current.userInterfaceStyle == .dark {
                    Image(resource: \.logolandblanc)
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 300, height: 320)
                } else {
                    Image(resource: \.logoauth)
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 250, height: 220)
                }
                Text(IosStringResources(id: SharedRes.strings().page_one_title, args: []))
                    .font(.custom(.h2Medium))
                    .fontWeight(.bold)
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                Text(IosStringResources(id: SharedRes.strings().page_one_topic, args: []))
                    .font(.custom("Poppins-Regular", size: 12))
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                ButtonNext(condition: eventClick)
            }.padding()
        }
    }
}

#Preview {
    PageOneIntroduction(eventClick: {})
}
