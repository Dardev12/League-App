//
//  PageTwoUseCase.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PageTwoUseCase: View {
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
                Text(IosStringResources(id: SharedRes.strings().page_two_title, args: []))
                    .font(.custom(.h1Medium))
                    .fontWeight(.bold)
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                Text(IosStringResources(id: SharedRes.strings().page_two_topic, args: []))
                    .font(.custom(.pBody))
                    .multilineTextAlignment(.center)
                    .foregroundColor(Color.textColor)
                ButtonNext(condition: eventClick)
            }.padding()
        }
    }
}

#Preview {
    PageTwoUseCase(eventClick: {})
}
