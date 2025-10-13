//
//  LandButtonExplore.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ButtonExplore: View {
    var condition: () -> Void

    var body: some View {
        Button(action: {
            condition()
        }) {
            Spacer()
            Text(IosStringResources(id:SharedRes.strings().validate_onboarding_button,args:[]))
                .fontWeight(.bold)
                .font(.custom(.h3Large))
                .foregroundColor(Color.white)
                .padding()
            Spacer()
        }.frame( height: 75).background(Color.feedbackBoxBackground).cornerRadius(50).padding()
    }
}

#Preview {
    ButtonExplore(condition: {})
}
