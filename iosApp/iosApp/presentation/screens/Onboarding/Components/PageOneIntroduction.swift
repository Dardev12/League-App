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
                Image(resource: \.info)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 250, height: 250)
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
