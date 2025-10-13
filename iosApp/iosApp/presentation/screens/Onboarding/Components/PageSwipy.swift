//
//  PageSwipy.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PageSwipy: View {
    var eventClick: () -> Void
    
    var body: some View {
        ZStack {
            Color.background
                .ignoresSafeArea()
            VStack(alignment: .center){
                Image(resource: \.swipy)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 200, height: 330)
                Text(IosStringResources(id: SharedRes.strings().page_three_title, args: []))
                    .font(.custom(.h1Medium))
                    .fontWeight(.bold)
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                Text(IosStringResources(id: SharedRes.strings().page_three_topic, args: []))
                    .font(.custom("Poppins-Regular", size: 12))
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                ButtonNext(condition: eventClick)
            }.padding()
        }
    }
}

#Preview {
    PageSwipy(eventClick: {})
}
